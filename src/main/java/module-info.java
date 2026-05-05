module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens br.com.sp.jandira.senai.VagaCerta to javafx.fxml;
    exports br.com.sp.jandira.senai.VagaCerta;
}
