/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiStart;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

import objects.Mp3Player;
import objects.Mp3;
import utils.FileUtils;
import utils.Mp3PlayerFileFilter;
import utils.SkinUtils;


/**
 *
 * @author rustam
 */
public class PleerOnSwingxStart extends javax.swing.JFrame implements BasicPlayerListener {


    //<editor-fold defaultstate="collapsed" desc="constants">
    private static final String MP3_FILE_EXTENSION = "mp3";
    private static final String MP3_FILE_DESCRIPTION = "Файлы mp3";
    private static final String PLAYLIST_FILE_EXTENSION = "pls";
    private static final String PLAYLIST_FILE_DESCRIPTION = "Файлы плейлиста";
    private static final String EMPTY_STRING = "";
    private static final String INPUT_SONG_NAME = "input name of song";
    //</editor-fold>
    
    private DefaultListModel mp3ListMODEL = new DefaultListModel();
    private Mp3PlayerFileFilter Mp3playerFileFilter = new Mp3PlayerFileFilter(MP3_FILE_EXTENSION, MP3_FILE_DESCRIPTION);
    private FileFilter playlistFileFilter = new Mp3PlayerFileFilter(PLAYLIST_FILE_EXTENSION, PLAYLIST_FILE_DESCRIPTION);
    private Mp3Player player = new Mp3Player(this);
    
    

    //<editor-fold defaultstate="collapsed" desc="variabels fo scrollind song">
    private long duration;
    private int bytesLen;
    private long secondAmount;
    private boolean movingFromJump = false;
    private boolean moveAutomatic = false;
    private double posValue = 0.0;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BasicPlayer listener">
    @Override
    public void opened(Object o, Map map) {
        duration = (long)Math.round((((Long)map.get("duration")).longValue()) / 1000000);
        bytesLen = (int) Math.round(((Integer)map.get("mp3.length.bytes")).intValue());
        // Choose sourse of title. If map has Ok if not use FileUtils.
        String songName = map.get("title")
                != null ? songName = map.get("title").toString() :
                FileUtils.getFileNameWithoutExtension(new File(o.toString()).getName());
        // Cut song if length > 35.
        if (songName.length() > 35) {
            songName = songName.substring(0, 35) + "...";
        }
        // Set name to Label.
        jLabelNameOfSong.setText(songName);
    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {
        float progress = -1.0f;
        if (i > 0 && (duration > 0)){
            progress = i * 1.0f / bytesLen * 1.0f;
        }
        secondAmount = (long)(duration * progress);
        if (duration != 0 && movingFromJump == false) {
            jSliderProgres.setValue((int) Math.round(secondAmount * 1000 / duration));
        }
    }

    @Override
    public void stateUpdated(BasicPlayerEvent bpe) {
        int state = bpe.getCode();
        
        if (state == BasicPlayerEvent.PLAYING) {
            movingFromJump = false;
        } else if (state == BasicPlayerEvent.SEEKING) {
            movingFromJump = true;
        } else if (state == BasicPlayerEvent.EOM && selectNextSong()) {
            playFile();
        }
    }
    
    @Override    
    public void setController(BasicController bc) {
    }

    //</editor-fold>
    /**
     * Creates new form PleerOnSwingxForm
     */
    public PleerOnSwingxStart() {
        initComponents();
    }
    
    public void playFile() {
        int[] indicesArrayForPlay = jListPlayList.getSelectedIndices();
        if (indicesArrayForPlay.length > 0) {
            if (mp3ListMODEL.getElementAt(indicesArrayForPlay[0]) instanceof Mp3) {
                Mp3 mp3 = (Mp3)mp3ListMODEL.getElementAt(indicesArrayForPlay[0]);
                player.play(mp3.getPath());
                player.setVolume(jSliderVolume.getValue(), jSliderVolume.getMaximum());
            }
        }
    }
    
    public boolean selectPreviosSong() {
        int previosIndex = jListPlayList.getSelectedIndex() - 1;
        if (previosIndex >= 0) {
            jListPlayList.setSelectedIndex(previosIndex);
        }
        return false;
    }
    
    public boolean selectNextSong() {
        int nextIndex = jListPlayList.getSelectedIndex() + 1;
        if (nextIndex <= jListPlayList.getModel().getSize() - 1) {
            jListPlayList.setSelectedIndex(nextIndex);
            return true;
        }
        return false;
    }
    
    public void searchSong() {
        String searchName = jTextFieldSearch.getText();
        if (searchName.trim().equals(EMPTY_STRING) || searchName == null) {
            return;
        }
        // Finded songs collection
        List<Integer> findedSongs = new ArrayList<Integer>();
        for (int i = 0; i < mp3ListMODEL.size(); i++) {
            Mp3 mp3 = (Mp3)mp3ListMODEL.getElementAt(i);
            if (mp3.getName().toUpperCase().contains(searchName.toUpperCase())) {
                findedSongs.add(i);
            }
        }
        // Finded songs array
        int[] selectedIndices = new int[findedSongs.size()];
        if (selectedIndices.length == 0) {
            JOptionPane.showMessageDialog(this, "Searching \'" + searchName + "\' didn't give result");
            jTextFieldSearch.requestFocus();
            jTextFieldSearch.selectAll();
            return;
        }
        // Convert Collection to Array
        for (int i = 0; i < selectedIndices.length; i++) {
            selectedIndices[i] = findedSongs.get(i).intValue();
        }
        // Mark selected songs in jList
        jListPlayList.setSelectedIndices(selectedIndices);
    }
    
    public void processSeek(double bytes) {
        try {
            long skipBytes = (long) Math.round(((Integer) bytesLen).intValue() * bytes);
            player.jump(skipBytes);
        } catch (Exception e) {
            e.printStackTrace();
            movingFromJump = false;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jPopupMenu = new javax.swing.JPopupMenu();
        jMenuItemAddSong = new javax.swing.JMenuItem();
        jMenuItemDeleteSong = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JPopupMenu.Separator();
        jMenuItemOpenPlayList = new javax.swing.JMenuItem();
        jMenuItemClearPlayList = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPlaySong = new javax.swing.JMenuItem();
        jMenuItemStopSong = new javax.swing.JMenuItem();
        jMenuItemPause = new javax.swing.JMenuItem();
        jPanelSearch = new javax.swing.JPanel();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jPanelMain = new javax.swing.JPanel();
        jButtonPreviousSong = new javax.swing.JButton();
        jButtonPause = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();
        jButtonNextSong = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jSliderVolume = new javax.swing.JSlider();
        jToggleButtonVolume = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPlayList = new javax.swing.JList();
        jButtonAddSong = new javax.swing.JButton();
        jButtonDeleteSong = new javax.swing.JButton();
        jButtonScrollDown = new javax.swing.JButton();
        jButtonScrollUp = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelNameOfSong = new javax.swing.JLabel();
        jSliderProgres = new javax.swing.JSlider();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuOpenPlayList = new javax.swing.JMenuItem();
        jMenuSavePlaylist = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuExit = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuChangeSkin = new javax.swing.JMenu();
        jSubMenuChangeSkin1 = new javax.swing.JMenuItem();
        jSubMenuChangeSkin2 = new javax.swing.JMenuItem();
        jSubMenuChangeSkin3 = new javax.swing.JMenuItem();

        jFileChooser.setAcceptAllFileFilterUsed(false);
        jFileChooser.setMultiSelectionEnabled(true);

        jMenuItemAddSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/plus_16.png"))); // NOI18N
        jMenuItemAddSong.setText("add song");
        jMenuItemAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPopAddSongActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemAddSong);

        jMenuItemDeleteSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/remove_icon.png"))); // NOI18N
        jMenuItemDeleteSong.setText("delete song");
        jMenuItemDeleteSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPopDeleteSongActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemDeleteSong);
        jPopupMenu.add(jSeparator);

        jMenuItemOpenPlayList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/open-icon.png"))); // NOI18N
        jMenuItemOpenPlayList.setText("open playlist");
        jMenuItemOpenPlayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPopOpenPlayListActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemOpenPlayList);

        jMenuItemClearPlayList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/clear.png"))); // NOI18N
        jMenuItemClearPlayList.setText("clear playlist");
        jMenuItemClearPlayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPopClearPlayListActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemClearPlayList);
        jPopupMenu.add(jSeparator3);

        jMenuItemPlaySong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/Play.png"))); // NOI18N
        jMenuItemPlaySong.setText("play");
        jMenuItemPlaySong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPopPlaySongActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemPlaySong);

        jMenuItemStopSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/stop-red-icon.png"))); // NOI18N
        jMenuItemStopSong.setText("stop");
        jMenuItemStopSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPopStopSongActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemStopSong);

        jMenuItemPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/Pause-icon.png"))); // NOI18N
        jMenuItemPause.setText("pause");
        jMenuItemPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPopPauseActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuItemPause);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mp3 Player");

        jPanelSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/search_16.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.setToolTipText("Search treck");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTextFieldSearch.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jTextFieldSearch.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldSearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldSearch.setText("input name of song");
        jTextFieldSearch.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        jTextFieldSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchFocusLost(evt);
            }
        });
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSearchLayout = new javax.swing.GroupLayout(jPanelSearch);
        jPanelSearch.setLayout(jPanelSearchLayout);
        jPanelSearchLayout.setHorizontalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSearch)
                .addContainerGap())
            .addGroup(jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSearchLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );
        jPanelSearchLayout.setVerticalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSearchLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jTextFieldSearch)
                    .addGap(10, 10, 10)))
        );

        jPanelMain.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonPreviousSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/prev-icon.png"))); // NOI18N
        jButtonPreviousSong.setToolTipText("Previous track");
        jButtonPreviousSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousSongActionPerformed(evt);
            }
        });

        jButtonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/Pause-icon.png"))); // NOI18N
        jButtonPause.setToolTipText("Pause");
        jButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPauseActionPerformed(evt);
            }
        });

        jButtonPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/Play.png"))); // NOI18N
        jButtonPlay.setToolTipText("Play music");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        jButtonNextSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/next-icon.png"))); // NOI18N
        jButtonNextSong.setToolTipText("Next track");
        jButtonNextSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextSongActionPerformed(evt);
            }
        });

        jButtonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/stop-red-icon.png"))); // NOI18N
        jButtonStop.setToolTipText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jSliderVolume.setMaximum(200);
        jSliderVolume.setMinorTickSpacing(5);
        jSliderVolume.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderVolume.setSnapToTicks(true);
        jSliderVolume.setToolTipText("change volume");
        jSliderVolume.setValue(100);
        jSliderVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderVolumeStateChanged(evt);
            }
        });

        jToggleButtonVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/speaker.png"))); // NOI18N
        jToggleButtonVolume.setToolTipText("Mute");
        jToggleButtonVolume.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/mute.png"))); // NOI18N
        jToggleButtonVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonVolumeActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("playlist");

        jListPlayList.setFont(new java.awt.Font("Monaco", 1, 12)); // NOI18N
        jListPlayList.setModel(mp3ListMODEL);
        jListPlayList.setToolTipText("list of songs");
        jListPlayList.setComponentPopupMenu(jPopupMenu);
        jListPlayList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseDoubleClicked(evt);
            }
        });
        jListPlayList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jListPlayListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jListPlayList);

        jButtonAddSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/plus_16.png"))); // NOI18N
        jButtonAddSong.setToolTipText("Add new track");
        jButtonAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSongActionPerformed(evt);
            }
        });

        jButtonDeleteSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/remove_icon.png"))); // NOI18N
        jButtonDeleteSong.setToolTipText("Remove selected track");
        jButtonDeleteSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteSongActionPerformed(evt);
            }
        });

        jButtonScrollDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/arrow-down-icon.png"))); // NOI18N
        jButtonScrollDown.setToolTipText("Scroll down");
        jButtonScrollDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScrollDownActionPerformed(evt);
            }
        });

        jButtonScrollUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/arrow-up-icon.png"))); // NOI18N
        jButtonScrollUp.setToolTipText("Scroll up");
        jButtonScrollUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScrollUpActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelNameOfSong.setText("...");

        jSliderProgres.setMaximum(1000);
        jSliderProgres.setMinorTickSpacing(1);
        jSliderProgres.setSnapToTicks(true);
        jSliderProgres.setToolTipText("volume");
        jSliderProgres.setValue(0);
        jSliderProgres.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderProgresStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                                .addComponent(jButtonAddSong, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteSong, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jButtonScrollDown, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonScrollUp, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addComponent(jButtonPreviousSong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jButtonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jButtonNextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 6, Short.MAX_VALUE))
                                    .addComponent(jSliderProgres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jLabelNameOfSong)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderVolume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButtonVolume, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddSong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteSong, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonScrollDown, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonScrollUp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSliderVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButtonVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabelNameOfSong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderProgres, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPause, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonStop, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNextSong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPreviousSong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        jMenuFile.setText("File");

        jMenuOpenPlayList.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        jMenuOpenPlayList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/open-icon.png"))); // NOI18N
        jMenuOpenPlayList.setText("Open playlist");
        jMenuOpenPlayList.setToolTipText("Open new playlist");
        jMenuOpenPlayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpenPlayListActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuOpenPlayList);

        jMenuSavePlaylist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        jMenuSavePlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/save_16.png"))); // NOI18N
        jMenuSavePlaylist.setText("Save playlist");
        jMenuSavePlaylist.setToolTipText("Save current playlist");
        jMenuSavePlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSavePlaylistActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuSavePlaylist);
        jMenuFile.add(jSeparator1);

        jMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        jMenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/exit.png"))); // NOI18N
        jMenuExit.setText("Exit");
        jMenuExit.setToolTipText("Quit");
        jMenuFile.add(jMenuExit);

        jMenuBar.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuChangeSkin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesPleer/gear_16.png"))); // NOI18N
        jMenuChangeSkin.setText("skins");

        jSubMenuChangeSkin1.setText("skin 1");
        jSubMenuChangeSkin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubMenuChangeSkin1Pressed(evt);
            }
        });
        jMenuChangeSkin.add(jSubMenuChangeSkin1);

        jSubMenuChangeSkin2.setText("skin 2");
        jSubMenuChangeSkin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubMenuChangeSkin2Pressed(evt);
            }
        });
        jMenuChangeSkin.add(jSubMenuChangeSkin2);

        jSubMenuChangeSkin3.setText("skin 3");
        jSubMenuChangeSkin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubMenuChangeSkin3Pressed(evt);
            }
        });
        jMenuChangeSkin.add(jSubMenuChangeSkin3);

        jMenuEdit.add(jMenuChangeSkin);

        jMenuBar.add(jMenuEdit);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int currentVolumeValue;
    private void jToggleButtonVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonVolumeActionPerformed
        if (jToggleButtonVolume.isSelected()) {
            currentVolumeValue = jSliderVolume.getValue();
            jSliderVolume.setValue(0);
        } else {
            jSliderVolume.setValue(currentVolumeValue);
        }
    }//GEN-LAST:event_jToggleButtonVolumeActionPerformed

    private void jSubMenuChangeSkin1Pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubMenuChangeSkin1Pressed
        
        SkinUtils.changeSkin(new AluminiumLookAndFeel(), this);
        
    }//GEN-LAST:event_jSubMenuChangeSkin1Pressed

    private void jSubMenuChangeSkin2Pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubMenuChangeSkin2Pressed
      
        SkinUtils.changeSkin(new HiFiLookAndFeel(), this);
        
    }//GEN-LAST:event_jSubMenuChangeSkin2Pressed

    private void jSubMenuChangeSkin3Pressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSubMenuChangeSkin3Pressed
        
        SkinUtils.changeSkin(new LunaLookAndFeel(), this);
        
    }//GEN-LAST:event_jSubMenuChangeSkin3Pressed
// Add song Button.
    private void jButtonAddSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSongActionPerformed
        FileUtils.setFileFilter(jFileChooser, Mp3playerFileFilter);
        int result = jFileChooser.showOpenDialog(this);
        
        if (result == jFileChooser.APPROVE_OPTION) {
            File [] selectedFiles = jFileChooser.getSelectedFiles();
            
            for (File file : selectedFiles) {
                Mp3 mp3 = new Mp3(file.getName(), file.getPath());
                if (!(mp3ListMODEL.contains(mp3))) {
                    mp3ListMODEL.addElement(mp3);
                }
            }
        }
    }//GEN-LAST:event_jButtonAddSongActionPerformed
// Remove song.
    private void jButtonDeleteSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteSongActionPerformed
        
        int[] indicesArrayForRemove = jListPlayList.getSelectedIndices();// Array to get indices of selected songs.
        
        if (indicesArrayForRemove.length > 0) { // If chosed even one song.
            
            List<Mp3> collectionForRemove = new ArrayList<Mp3>(); // Collection of selected files to removing.
            
            for (int i = 0; i < indicesArrayForRemove.length; i++) { // If ech element instance of Mp3.
                
                if (mp3ListMODEL.getElementAt(indicesArrayForRemove[i]) instanceof Mp3) {
                    Mp3 mp3 = (Mp3)mp3ListMODEL.getElementAt(indicesArrayForRemove[i]);
                    collectionForRemove.add(mp3); // Add to collection Mp3.
                }
            }
            for (Mp3 mp3 : collectionForRemove) { // Remove Mp3 from song List.
                mp3ListMODEL.removeElement(mp3);
            }
        }
        
    }//GEN-LAST:event_jButtonDeleteSongActionPerformed
// Select next song.
    private void jButtonScrollDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScrollDownActionPerformed
       selectNextSong();
    }//GEN-LAST:event_jButtonScrollDownActionPerformed
// Select previos song.
    private void jButtonScrollUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScrollUpActionPerformed
        selectPreviosSong();
    }//GEN-LAST:event_jButtonScrollUpActionPerformed
// Play song button.
    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        playFile();
    }//GEN-LAST:event_jButtonPlayActionPerformed

    private void jMenuSavePlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSavePlaylistActionPerformed
        
        FileUtils.setFileFilter(jFileChooser, playlistFileFilter);
        
        int result = jFileChooser.showSaveDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {// если нажата клавиша OK или YES
            
            File selectedFile = jFileChooser.getSelectedFile();
            
            if (selectedFile.exists()) {// если такой файл уже существует

                int resultOvveride = JOptionPane.showConfirmDialog(this, "Файл существует", "Перезаписать?", JOptionPane.YES_NO_CANCEL_OPTION);
                
                switch (resultOvveride) {
                    case JOptionPane.NO_OPTION:
                        jMenuSavePlaylistActionPerformed(evt);// повторно открыть окно сохранения файла
                        return;
                    case JOptionPane.CANCEL_OPTION:
                        jFileChooser.cancelSelection();
                        return;
                        
                }
                jFileChooser.approveSelection();
            }

            String fileExtension = FileUtils.getFileExtension(selectedFile);

            // имя файла (нужно ли добавлять раширение к имени файлу при сохранении)
            String fileNameForSave = (fileExtension != null && fileExtension.equals(PLAYLIST_FILE_EXTENSION)) ? selectedFile.getPath() : selectedFile.getPath() + "." + PLAYLIST_FILE_EXTENSION;

            FileUtils.serialize(mp3ListMODEL, fileNameForSave);
        }
    }//GEN-LAST:event_jMenuSavePlaylistActionPerformed

    private void jMenuOpenPlayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpenPlayListActionPerformed
        
        FileUtils.setFileFilter(jFileChooser, playlistFileFilter);
        int result = jFileChooser.showOpenDialog(this);// result хранит результат: выбран файл или нет

        if (result == JFileChooser.APPROVE_OPTION) {// если нажата клавиша OK или YES
            File selectedFile = jFileChooser.getSelectedFile();
            DefaultListModel listMp3Model = (DefaultListModel)FileUtils.deserialize(selectedFile.getPath());
            this.mp3ListMODEL = listMp3Model;
            jListPlayList.setModel(listMp3Model);
        }
    }//GEN-LAST:event_jMenuOpenPlayListActionPerformed

    private void jTextFieldSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusGained
        
        if(jTextFieldSearch.getText().equals(INPUT_SONG_NAME)) {
            jTextFieldSearch.setText(EMPTY_STRING);
        }
    }//GEN-LAST:event_jTextFieldSearchFocusGained

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        searchSong();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jTextFieldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchFocusLost
        if (jTextFieldSearch.getText().trim().equals(EMPTY_STRING)) {
            jTextFieldSearch.setText(INPUT_SONG_NAME);
        }
    }//GEN-LAST:event_jTextFieldSearchFocusLost

    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
        player.pause();
    }//GEN-LAST:event_jButtonPauseActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        player.stop();
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonPreviousSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousSongActionPerformed
        if (selectPreviosSong()) {
            playFile();
        }
    }//GEN-LAST:event_jButtonPreviousSongActionPerformed

    private void jButtonNextSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextSongActionPerformed
        if (selectNextSong()) {
            playFile();
        }
    }//GEN-LAST:event_jButtonNextSongActionPerformed

    private void jSliderVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderVolumeStateChanged
        
        player.setVolume(jSliderVolume.getValue(), jSliderVolume.getMaximum());
        
        if (jSliderVolume.getValue() == 0) {
            jToggleButtonVolume.setSelected(true);
        } else {
            jToggleButtonVolume.setSelected(false);
        }
    }//GEN-LAST:event_jSliderVolumeStateChanged

    private void listMouseDoubleClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseDoubleClicked
        if (evt.getModifiers() == InputEvent.BUTTON1_MASK && evt.getClickCount() == 2) {
            playFile();
        }
    }//GEN-LAST:event_listMouseDoubleClicked

    private void jListPlayListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListPlayListKeyPressed
        int keyPressed = evt.getKeyCode();
        if (keyPressed == KeyEvent.VK_ENTER) {
            playFile();
        }
    }//GEN-LAST:event_jListPlayListKeyPressed

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        int keyPressed = evt.getKeyCode();
        if (keyPressed == KeyEvent.VK_ENTER) {
            searchSong();
        }
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jSliderProgresStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderProgresStateChanged
        if (jSliderProgres.getValueIsAdjusting() == false) {
            if (moveAutomatic == true) {
                moveAutomatic = false;
                posValue = jSliderProgres.getValue() * 1.0 / 1000;
                processSeek(posValue);
            } else {
                moveAutomatic = true;
                movingFromJump = true;
            }
        }
    }//GEN-LAST:event_jSliderProgresStateChanged

    private void jMenuPopAddSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPopAddSongActionPerformed
        jButtonAddSongActionPerformed(evt);
    }//GEN-LAST:event_jMenuPopAddSongActionPerformed

    private void jMenuPopDeleteSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPopDeleteSongActionPerformed
        jButtonDeleteSongActionPerformed(evt);
    }//GEN-LAST:event_jMenuPopDeleteSongActionPerformed

    private void jMenuPopOpenPlayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPopOpenPlayListActionPerformed
        jMenuOpenPlayListActionPerformed(evt);
    }//GEN-LAST:event_jMenuPopOpenPlayListActionPerformed

    private void jMenuPopClearPlayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPopClearPlayListActionPerformed
        mp3ListMODEL.clear();
    }//GEN-LAST:event_jMenuPopClearPlayListActionPerformed

    private void jMenuPopPlaySongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPopPlaySongActionPerformed
        jButtonPlayActionPerformed(evt);
    }//GEN-LAST:event_jMenuPopPlaySongActionPerformed

    private void jMenuPopStopSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPopStopSongActionPerformed
        jButtonStopActionPerformed(evt);
    }//GEN-LAST:event_jMenuPopStopSongActionPerformed

    private void jMenuPopPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPopPauseActionPerformed
        jButtonPauseActionPerformed(evt);
    }//GEN-LAST:event_jMenuPopPauseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            
            UIManager.setLookAndFeel(new LunaLookAndFeel());
            //</editor-fold>
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PleerOnSwingxStart.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PleerOnSwingxStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddSong;
    private javax.swing.JButton jButtonDeleteSong;
    private javax.swing.JButton jButtonNextSong;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JButton jButtonPreviousSong;
    private javax.swing.JButton jButtonScrollDown;
    private javax.swing.JButton jButtonScrollUp;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabelNameOfSong;
    private javax.swing.JList jListPlayList;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuChangeSkin;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemAddSong;
    private javax.swing.JMenuItem jMenuItemClearPlayList;
    private javax.swing.JMenuItem jMenuItemDeleteSong;
    private javax.swing.JMenuItem jMenuItemOpenPlayList;
    private javax.swing.JMenuItem jMenuItemPause;
    private javax.swing.JMenuItem jMenuItemPlaySong;
    private javax.swing.JMenuItem jMenuItemStopSong;
    private javax.swing.JMenuItem jMenuOpenPlayList;
    private javax.swing.JMenuItem jMenuSavePlaylist;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSlider jSliderProgres;
    private javax.swing.JSlider jSliderVolume;
    private javax.swing.JMenuItem jSubMenuChangeSkin1;
    private javax.swing.JMenuItem jSubMenuChangeSkin2;
    private javax.swing.JMenuItem jSubMenuChangeSkin3;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToggleButton jToggleButtonVolume;
    // End of variables declaration//GEN-END:variables
}
