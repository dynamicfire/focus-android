/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.web

import android.os.Environment
import android.os.Parcel
import android.os.Parcelable

class Download(val url: String,
               val userAgent: String?,
               val contentDisposition: String?,
               val mimeType: String?,
               val contentLength: Long,
               val destinationDirectory: String = Environment.DIRECTORY_DOWNLOADS
) : Parcelable {

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(url)
        dest.writeString(userAgent)
        dest.writeString(contentDisposition)
        dest.writeString(mimeType)
        dest.writeLong(contentLength)
        dest.writeString(destinationDirectory)
    }

    companion object {
        val CREATOR: Parcelable.Creator<Download> = object : Parcelable.Creator<Download> {

            override fun createFromParcel(source: Parcel): Download {
                return Download(
                        source.readString(),
                        source.readString(),
                        source.readString(),
                        source.readString(),
                        source.readLong(),
                        source.readString())
            }

            override fun newArray(size: Int): Array<Download?> {
                return arrayOfNulls(size)
            }
        }
    }
}
