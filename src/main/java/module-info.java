module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.sp.jandira.senai.VagaCerta to javafx.fxml;
    exports br.com.sp.jandira.senai.VagaCerta;
}