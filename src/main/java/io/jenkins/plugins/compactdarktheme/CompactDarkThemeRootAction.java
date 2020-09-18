package io.jenkins.plugins.compactdarktheme;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.apache.commons.io.IOUtils;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.WebMethod;

import static io.jenkins.plugins.compactdarktheme.CompactDarkThemeManagerFactory.THEME_CSS;
import static io.jenkins.plugins.compactdarktheme.CompactDarkThemeManagerFactory.THEME_URL_NAME;
import static io.jenkins.plugins.compactdarktheme.CompactDarkThemeSystemManagerFactory.THEME_SYSTEM_CSS;
import static java.util.Objects.requireNonNull;

@Extension
@Restricted(NoExternalUse.class)
public class CompactDarkThemeRootAction implements UnprotectedRootAction {

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return THEME_URL_NAME;
    }

    @WebMethod(name = THEME_CSS)
    public void doCompactDarkThemeCss(StaplerRequest req, StaplerResponse res) throws IOException {
        try (InputStream themeInputStream = getClass().getResourceAsStream(THEME_CSS)) {
            res.setContentType("text/css");
            requireNonNull(themeInputStream);
            String s1 = IOUtils.toString(themeInputStream, StandardCharsets.UTF_8);
            res.getWriter().print(s1);
        }
    }

    @WebMethod(name = THEME_SYSTEM_CSS)
    public void doCompactDarkThemeSystemCss(StaplerRequest req, StaplerResponse res) throws IOException {
        try (InputStream themeInputStream = getClass().getResourceAsStream(THEME_SYSTEM_CSS)) {
            res.setContentType("text/css");
            Objects.requireNonNull(themeInputStream);
            String s1 = IOUtils.toString(themeInputStream, StandardCharsets.UTF_8);
            res.getWriter().print(s1);
        }
    }
}
