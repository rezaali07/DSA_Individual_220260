package six;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class Imagesdownloader extends javax.swing.JFrame {

    private ExecutorService executorService;
    private static final String DOWNLOAD_DIRECTORY = "./downloaded_file/";
    private List<Future<?>> downloadTasks;
    private Map<Future<?>, DownloadInfo> downloadInfoMap;
    public Imagesdownloader() {
        initComponents();
        executorService = Executors.newFixedThreadPool(5);
        downloadTasks = new CopyOnWriteArrayList<>();
        downloadInfoMap = new ConcurrentHashMap<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textImage = new javax.swing.JLabel();
        inputarea = new javax.swing.JTextField();
        progressindicator = new javax.swing.JProgressBar();
        cancel_btn = new javax.swing.JButton();
        download_btn = new javax.swing.JButton();
        pause_btn = new javax.swing.JButton();
        resume_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        textImage.setFont(new java.awt.Font("Candara Light", 1, 64)); // NOI18N
        textImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textImage.setText("Image Downloader");

        inputarea.setBackground(new java.awt.Color(204, 204, 204));
        inputarea.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        inputarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputareaActionPerformed(evt);
            }
        });

        progressindicator.setBackground(new java.awt.Color(255, 255, 255));

        cancel_btn.setBackground(new java.awt.Color(255, 0, 51));
        cancel_btn.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        cancel_btn.setText("Cancel");
        cancel_btn.setBorder(null);
        cancel_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        download_btn.setBackground(new java.awt.Color(102, 255, 204));
        download_btn.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        download_btn.setText("Download");
        download_btn.setBorder(null);
        download_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        download_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        download_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                download_btnActionPerformed(evt);
            }
        });

        pause_btn.setBackground(new java.awt.Color(102, 255, 204));
        pause_btn.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        pause_btn.setText("Pause");
        pause_btn.setBorder(null);
        pause_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pause_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_btnActionPerformed(evt);
            }
        });

        resume_btn.setBackground(new java.awt.Color(102, 255, 204));
        resume_btn.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        resume_btn.setText("Resume");
        resume_btn.setBorder(null);
        resume_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resume_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resume_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Candara Light", 0, 20)); // NOI18N
        jLabel1.setText("Seperate with comma(,) or space to download mulitple image");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(progressindicator, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(download_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(74, 74, 74)
                                        .addComponent(pause_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(resume_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(inputarea, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(textImage, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(textImage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(inputarea, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(progressindicator, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pause_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(download_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resume_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(140, 20, 1190, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        // TODO add your handling code here:
        cancelDownloads();
         
        
        
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void download_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_download_btnActionPerformed
        // TODO add your handling code here:
        String urlsText = inputarea.getText();
                String[] urls = urlsText.split("[,\\s]+"); // Split the text by commas or whitespace
                for (String url : urls) {
                    if (!url.isEmpty()) {
                        downloadImage(url);
                    }
                }
        
    }//GEN-LAST:event_download_btnActionPerformed

    private void pause_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause_btnActionPerformed
        // TODO add your handling code here:
        pauseDownloads();
    }//GEN-LAST:event_pause_btnActionPerformed

    private void resume_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resume_btnActionPerformed
        // TODO add your handling code here:
        resumeDownloads();
    }//GEN-LAST:event_resume_btnActionPerformed

    private void inputareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputareaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void downloadImage(String urlString) {
        Runnable downloadTask = new Runnable() {
            @Override
            public void run() {
                DownloadInfo downloadInfo = downloadInfoMap.get(Thread.currentThread());
                int progress = downloadInfo != null ? downloadInfo.getProgress() : 0;
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");

                    if (progress > 0) {
                        connection.setRequestProperty("Range", "bytes=" + progress + "-");
                    }

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_PARTIAL) {
                        int contentLength = connection.getContentLength();
                        InputStream inputStream = connection.getInputStream();
                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int bytesRead;

                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                            progress += bytesRead;
                            int currentProgress = (int) ((progress / (double) contentLength) * 100);
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    progressindicator.setValue(currentProgress);
                                }
                            });

                            if (Thread.currentThread().isInterrupted()) {
                                throw new InterruptedException("Download interrupted");
                            }

                            Thread.sleep(50);
                        }

                        String fileName = "image_" + System.currentTimeMillis() + ".jpg";
                        saveImage(outputStream.toByteArray(), fileName);

//                        JOptionPane.showMessageDialog(ImageDownloaderApp.this,
//                                "Image downloaded successfully!");

                        inputStream.close();
                        outputStream.close();
                    } else {
                        throw new IOException("Failed to download image. Response code: " + responseCode);
                    }
                } catch (IOException | InterruptedException e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    if (!(e instanceof InterruptedException)) {
                        e.printStackTrace();
                       // JOptionPane.showMessageDialog(ImageDownloaderApp.this,
                              //  "Error downloading image: " + e.getMessage());
                    }
                }
            }
        };

        Future<?> task = executorService.submit(downloadTask);
        downloadTasks.add(task);
        downloadInfoMap.put(task, new DownloadInfo(urlString, 0));
    }

    private void saveImage(byte[] imageData, String fileName) {
        File directory = new File(DOWNLOAD_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fullPath = DOWNLOAD_DIRECTORY + fileName;

        try {
            FileOutputStream outputStream = new FileOutputStream(fullPath);
            outputStream.write(imageData);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resumeDownloads() {
        for (Future<?> task : downloadTasks) {
            if (task.isCancelled()) {
                DownloadInfo downloadInfo = downloadInfoMap.get(task);
                if (downloadInfo != null) {
                    downloadImage(downloadInfo.getUrl());
                }
            }
        }
    }
    private void pauseDownloads() {
        for (Future<?> task : downloadTasks) {
            if (!task.isDone() && !task.isCancelled()) {
                task.cancel(true);
            }
        }
    }
     private void cancelDownloads() {
        for (Future<?> task : downloadTasks) {
            task.cancel(true);
        }
        progressindicator.setValue(0);
    }
    private class DownloadInfo {
        private String url;
        private int progress;

        public DownloadInfo(String url, int progress) {
            this.url = url;
            this.progress = progress;
        }

        public String getUrl() {
            return url;
        }

        public int getProgress() {
            return progress;
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Imagesdownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imagesdownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imagesdownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imagesdownloader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Imagesdownloader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_btn;
    private javax.swing.JButton download_btn;
    private javax.swing.JTextField inputarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pause_btn;
    private javax.swing.JProgressBar progressindicator;
    private javax.swing.JButton resume_btn;
    private javax.swing.JLabel textImage;
    // End of variables declaration//GEN-END:variables
}
