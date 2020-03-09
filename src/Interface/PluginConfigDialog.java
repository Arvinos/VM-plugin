package Interface;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ComboBox;

import javax.annotation.Nullable;
import javax.swing.*;
import java.awt.*;

public class PluginConfigDialog extends DialogWrapper
{
    public PluginConfigDialog() {
        super(true); // use current window as parent
        init();
        setTitle("VM Config");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel()
    {
        JPanel pluginSettingsPanel = new JPanel(new BorderLayout());

        pluginSettingsPanel.add(getMachineSettingPanel(), BorderLayout.NORTH);
        pluginSettingsPanel.add(getBinaryImagePanel(), BorderLayout.CENTER);
        pluginSettingsPanel.add(getCommandLineArgumentsPanel(), BorderLayout.SOUTH);

        return pluginSettingsPanel;
    }

    private JPanel getMachineSettingPanel()
    {
        JPanel panel = new JPanel(new GridLayout());
        JLabel label = new JLabel("Virtual machine type:");
        ComboBox<String> machines = new ComboBox<>();

        // Set Label Properties
        panel.setPreferredSize(new Dimension(400, 35));
        //machines.setPreferredSize(new Dimension(200, 35));
        //label.setPreferredSize(new Dimension(200, 35));

        // Init machines list
        machines.addItem("i386");
        machines.addItem("arm");
        machines.addItem("amd");

        // Add UI onto panel
        panel.add(label);
        panel.add(machines);

        return panel;
    }

    private JPanel getBinaryImagePanel()
    {
        return new JPanel(new GridLayout()) ;
    }

    private JPanel getCommandLineArgumentsPanel()
    {
        return new JPanel(new BorderLayout());
    }

    public PluginSettings showAndGetSettings()
    {
        this.showAndGet();

        return new PluginSettings();
    }
}