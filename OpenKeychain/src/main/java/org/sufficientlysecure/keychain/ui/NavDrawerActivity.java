/*
 * Copyright (C) 2015 Dominik Schürmann <dominik@dominikschuermann.de>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.sufficientlysecure.keychain.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import org.sufficientlysecure.keychain.R;
import org.sufficientlysecure.keychain.remote.ui.AppsListFragment;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;

public abstract class NavDrawerActivity extends MaterialNavigationDrawer {

    @Override
    public void init(Bundle savedInstanceState) {
        // don't open drawer on first run
        disableLearningPattern();

//        addMultiPaneSupport();

        // set the header image
        // create and set the header
        View view = LayoutInflater.from(this).inflate(R.layout.drawer_custom_header, null);
        setDrawerHeaderCustom(view);

        // create sections
        addSection(newSection(getString(R.string.title_keys), R.drawable.ic_vpn_key_black_24dp, new KeyListFragment()));

        addSection(newSection(getString(R.string.title_encrypt_text), R.drawable.ic_lock_outline_black_24dp, new Intent(this, EncryptTextActivity.class)));
        addSection(newSection(getString(R.string.title_encrypt_files), R.drawable.ic_lock_outline_black_24dp, new Intent(this, EncryptFilesActivity.class)));
        addSection(newSection(getString(R.string.title_decrypt), R.drawable.ic_lock_open_black_24dp, new DecryptOverviewFragment()));
        addSection(newSection(getString(R.string.title_api_registered_apps), R.drawable.ic_apps_black_24dp, new AppsListFragment()));

        // create bottom section
        addBottomSection(newSection(getString(R.string.menu_preferences), R.drawable.ic_settings_black_24dp, new Intent(this, SettingsActivity.class)));
        addBottomSection(newSection(getString(R.string.menu_help), R.drawable.ic_help_black_24dp, new Intent(this, HelpActivity.class)));
    }
}
