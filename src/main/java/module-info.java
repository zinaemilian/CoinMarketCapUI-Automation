module com.example.coinmarketcapuiautomation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.coinmarketcapuiautomation to javafx.fxml;
    exports com.example.coinmarketcapuiautomation;
}