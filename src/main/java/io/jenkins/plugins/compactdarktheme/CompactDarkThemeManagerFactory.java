package io.jenkins.plugins.compactdarktheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class CompactDarkThemeManagerFactory extends ThemeManagerFactory {

    public static final String THEME_CSS = "theme.css";
    public static final String THEME_URL_NAME = "theme-compact-dark";

    @DataBoundConstructor
    public CompactDarkThemeManagerFactory() {
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .build();
    }
    
    @Extension
    @Symbol("compactDark")
    public static class CompactDarkThemeManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @NonNull
        @Override
        public String getDisplayName() {
            return "Compact Dark";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new CompactDarkThemeManagerFactory();
        }

        @NonNull
        @Override
        public String getThemeId() {
            return "compactDark";
        }
    }
}
