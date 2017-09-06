package com.liferay.gs.userformnav;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorCategory;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorConstants;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorEntry;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

/**
 * Created by eduardo on 6/09/17.
 */
@Component(
        immediate = true,
        property = {"service.ranking:Integer=20"},
        service = FormNavigatorCategory.class
)
public class DummyCategory implements FormNavigatorCategory {
    @Override
    public String getFormNavigatorId() {
        return FormNavigatorConstants.FORM_NAVIGATOR_ID_USERS;
    }

    @Override
    public String getKey() {
        return "DummyCategory";
    }

    @Override
    public String getLabel(Locale locale) {
        return "DummyCategory";
    }
}
