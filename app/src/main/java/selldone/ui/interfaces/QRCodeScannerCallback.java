package selldone.ui.interfaces;

import me.dm7.barcodescanner.zbar.BarcodeFormat;
import me.dm7.barcodescanner.zbar.Result;

public interface QRCodeScannerCallback {
    boolean onQRScanResult(Result rawResult, String contents, BarcodeFormat barcodeFormat);
}
