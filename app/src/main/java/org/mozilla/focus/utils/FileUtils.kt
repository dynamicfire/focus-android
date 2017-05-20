/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.utils

import android.content.Context

import java.io.File

object FileUtils {
    private val WEBVIEW_DIRECTORY = "app_webview"

    fun File.deleteContent() : Boolean {
        var success = true

        val files = list() ?: return false

        files
                .asSequence()
                .map { File(this, it) }
                .forEach {
                    if (it.isDirectory) {
                        success = success and deleteContent() && delete()
                    } else {
                        success = success and it.delete()
                    }
                }

        return success
    }

    fun truncateCacheDirectory(context: Context): Boolean {
        with (context.cacheDir) {
            return exists() && deleteContent()
        }
    }

    fun deleteWebViewDirectory(context: Context): Boolean {
        with (File(context.applicationInfo.dataDir, WEBVIEW_DIRECTORY)) {
            return exists() && deleteContent() && delete()
        }
    }
}
