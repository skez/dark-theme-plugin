package io.jenkins.plugins.compactdarktheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class CompactDarkThemeSystemManagerFactory extends ThemeManagerFactory {

    public static final String THEME_SYSTEM_CSS = "theme-system.css";

    @DataBoundConstructor
    public CompactDarkThemeSystemManagerFactory() {
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .build();
    }
    
    @Extension
    @Symbol("compactDarkSystem")
    public static class CompactDarkThemeSystemManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {
        
        @NonNull
        @Override
        public String getDisplayName() {
            return "Compact Dark (Respect OS/Browser system setting)";
        }

        @Override
        public String getThemeCssSuffix() {
            return "theme-system.css";
        }
        
        @Override
        public ThemeManagerFactory getInstance() {
            return new CompactDarkThemeSystemManagerFactory();
        }

        @NonNull
        @Override
        public String getThemeId() {
            return "compactDarkSystem";
        }
    }
}
