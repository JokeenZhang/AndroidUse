/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class) public class ScanResultTest {

  @Test public void testScanResultParceling() {
    BluetoothDevice device =
        BluetoothAdapter.getDefaultAdapter().getRemoteDevice("01:02:03:04:05:06");
    byte[] scanRecord = new byte[] {
        1, 2, 3
    };
    int rssi = -10;
    long timestampMicros = 10000L;
    ScanResult result =
        new ScanResult(device, ScanRecord.parseFromBytes(scanRecord), rssi, timestampMicros);
    Parcel parcel = Parcel.obtain();
    result.writeToParcel(parcel, 0);
    // Need to reset parcel data position to the beginning.
    parcel.setDataPosition(0);
    ScanResult resultFromParcel = ScanResult.CREATOR.createFromParcel(parcel);
    assertEquals(result, resultFromParcel);
  }
}
