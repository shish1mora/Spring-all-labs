module ru.karpov.laba6fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.web;


    opens ru.karpov.laba6fx to javafx.fxml;
    exports ru.karpov.laba6fx;
}