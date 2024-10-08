import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageProcessingApp extends JFrame {
    private JLabel originalImageLabel;
    private JLabel processedImageLabel;
    private JButton openButton;
    private JButton processButton;
    private JRadioButton medianFilter;

    private JRadioButton bernsenThresholding;
    private JRadioButton niblackThresholding;

    public ImageProcessingApp() {
        setTitle("Image Processing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        originalImageLabel = new JLabel();
        processedImageLabel = new JLabel();

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 2));
        imagePanel.add(originalImageLabel);
        imagePanel.add(processedImageLabel);
        add(imagePanel, BorderLayout.CENTER);

        openButton = new JButton("Открыть картинку");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });

        processButton = new JButton("Применить фильтр");
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processImage();
            }
        });

        medianFilter = new JRadioButton("Медианный фильтр");
        bernsenThresholding = new JRadioButton("Метод Бернсена");
        niblackThresholding = new JRadioButton("Метод Ниблацка");

        ButtonGroup processingGroup = new ButtonGroup();
        processingGroup.add(medianFilter);
        processingGroup.add(bernsenThresholding);
        processingGroup.add(niblackThresholding);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(medianFilter);
        buttonPanel.add(bernsenThresholding);
        buttonPanel.add(niblackThresholding);
        buttonPanel.add(processButton);
        add(buttonPanel, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser("D:\\Study\\БГУ\\5 семестр\\КГ\\labs\\Lab2_Var15\\src\\images");
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            Image image = imageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
            imageIcon = new ImageIcon(image);
            originalImageLabel.setIcon(imageIcon);
            processedImageLabel.setIcon(null);
        }
    }

    private void processImage() {
        ImageIcon imageIcon = (ImageIcon) originalImageLabel.getIcon();
        if (imageIcon == null) {
            JOptionPane.showMessageDialog(this, "Откройте изображение сначала.");
            return;
        }

        Image originalImage = imageIcon.getImage();
        BufferedImage bufferedImage = new BufferedImage(originalImage.getWidth(null), originalImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.dispose();

        BufferedImage resultImage;

        if (medianFilter.isSelected()) {
            resultImage = NonlinearFilter.medianFilter(bufferedImage, 3);
        } else if (bernsenThresholding.isSelected()) {
            resultImage = LocalThresholding.bernsenThresholding(bufferedImage, 15, 15);
        } else if (niblackThresholding.isSelected()) {
            resultImage = LocalThresholding.niblackThresholding(bufferedImage, 15,  -0.2);
        } else {
            JOptionPane.showMessageDialog(this, "Выберите метод обработки изображения.");
            return;
        }

        ImageIcon resultIcon = new ImageIcon(resultImage);
        processedImageLabel.setIcon(resultIcon);
        pack();
    }
}