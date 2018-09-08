package singh.rahul.com.app51preference;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class PreferenceActivity extends android.preference.PreferenceActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    addPreferencesFromResource(R.xml.preference_file);
    }
}
