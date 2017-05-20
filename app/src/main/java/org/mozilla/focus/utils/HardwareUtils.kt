/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.focus.utils

import android.content.Context

import org.mozilla.focus.R

class HardwareUtils {
    companion object {
        @JvmStatic
        fun isTablet(context: Context) = context.resources.getBoolean(R.bool.is_tablet)
    }
}
