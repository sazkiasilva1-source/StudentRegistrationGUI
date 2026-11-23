
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationGUI extends JFrame implements ActionListener {

    JTextField txtNama, txtNim;
    JComboBox<String> cmbJurusan;
    JButton btnSimpan, btnReset;

    public StudentRegistrationGUI() {

        setTitle("Student Registration Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblNama = new JLabel("NAMA");
        txtNama = new JTextField();

        lblNama.setFont(new Font("Arial", Font.BOLD, 13));
        txtNama.setFont(new Font("Arial", Font.PLAIN, 13));

        JLabel lblNim = new JLabel("NIM");
        txtNim = new JTextField();

        lblNim.setFont(new Font("Arial", Font.BOLD, 13));
        txtNim.setFont(new Font("Arial", Font.PLAIN, 13));

        JLabel lblJurusan = new JLabel("JURUSAN");
        String[] jurusan = {
            "Teknik Informatika",
            "Teknik Elektro",
            "Teknik Sipil",
            "Teknik Mesin",
            "Teknik Arsitektur",
            "Teknik Industri"
        };

        cmbJurusan = new JComboBox<>(jurusan);
        lblJurusan.setFont(new Font("Arial", Font.BOLD, 13));
        cmbJurusan.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSimpan = new JButton("Simpan");
        btnReset = new JButton("Reset");

        btnSimpan.addActionListener(this);
        btnReset.addActionListener(this);

        panelForm.add(lblNama);
        panelForm.add(txtNama);

        panelForm.add(lblNim);
        panelForm.add(txtNim);

        panelForm.add(lblJurusan);
        panelForm.add(cmbJurusan);

        panelForm.add(btnSimpan);
        panelForm.add(btnReset);

        panelUtama.add(panelForm, BorderLayout.CENTER);

        add(panelUtama);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSimpan) {

            String nama = txtNama.getText();
            String nim = txtNim.getText();
            String jurusan = cmbJurusan.getSelectedItem().toString();

            if (nama.isEmpty() || nim.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Nama dan NIM harus diisi!");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Data berhasil disimpan!\n\n"
                    + "Nama: " + nama
                    + "\nNIM: " + nim
                    + "\nJurusan: " + jurusan);
            }

        } else if (e.getSource() == btnReset) {

            txtNama.setText("");
            txtNim.setText("");
            cmbJurusan.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationGUI();
    }
}
