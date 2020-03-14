package Interface;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.EditorTextField;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;

import javax.annotation.Nullable;
import javax.swing.*;
import java.awt.*;

public class PluginConfigDialog extends DialogWrapper
{

    private static int DEFAULT_HEIGHT      = 40;
    private static int DEFAULT_BUTTON_SIDE = DEFAULT_HEIGHT;

    private static final Dimension PANELS_DEFAULT_SIZE     = new Dimension(500, DEFAULT_HEIGHT);
    private static final Dimension LABELS_DEFAULT_SIZE     = new Dimension(200, DEFAULT_HEIGHT);
    private static final Dimension EDIT_FIELD_DEFAULT_SIZE = new Dimension(250, DEFAULT_HEIGHT);
    private static final Dimension COMBO_BOX_DEFAULT_SIZE  = new Dimension(150, DEFAULT_HEIGHT);

    private static final Dimension BUTTON_DEFAULT_SIZE     = new Dimension(DEFAULT_BUTTON_SIDE,
                                                                           DEFAULT_BUTTON_SIDE);

    public PluginConfigDialog()
    {
        // Use current window as parent
        super(true);

        init();

        setTitle("VM Config");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel()
    {
        JPanel pluginSettingsPanel = new JPanel(new VerticalLayout());
        pluginSettingsPanel.setPreferredSize(PANELS_DEFAULT_SIZE);

        pluginSettingsPanel.add(getMachineSettingPanel());
        pluginSettingsPanel.add(getBinaryImagePanel());
        pluginSettingsPanel.add(getCommandLineArgumentsPanel());

        return pluginSettingsPanel;
    }

    private JPanel getMachineSettingPanel()
    {
        JPanel panel = new JPanel(new HorizontalLayout());
        JLabel label = new JLabel("Virtual machine type:");
        ComboBox<String> machines = new ComboBox<>();

        // Set Label Properties
        panel.setPreferredSize(PANELS_DEFAULT_SIZE);
        label.setPreferredSize(LABELS_DEFAULT_SIZE);
        machines.setPreferredSize(COMBO_BOX_DEFAULT_SIZE);

        // Init machines list (TODO Add auto filling)
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
        JPanel  panel          = new JPanel(new HorizontalLayout());
        JButton button         = new JButton("...");
        JLabel  label          = new JLabel("Binary Image Path:");
        EditorTextField editor = new EditorTextField();

        // Set sizes
        panel.setPreferredSize(PANELS_DEFAULT_SIZE);
        label.setPreferredSize(LABELS_DEFAULT_SIZE);
        button.setPreferredSize(BUTTON_DEFAULT_SIZE);
        editor.setPreferredSize(EDIT_FIELD_DEFAULT_SIZE);

        // Add UI components on the panel
        panel.add(label);
        panel.add(editor);
        panel.add(button);

        return panel;
    }

    private JPanel getCommandLineArgumentsPanel()
    {
        JPanel panel           = new JPanel(new HorizontalLayout());
        JLabel label           = new JLabel("Command Line Arguments:");
        EditorTextField editor = new EditorTextField();

        // Set sizes
        panel.setPreferredSize(PANELS_DEFAULT_SIZE);
        label.setPreferredSize(LABELS_DEFAULT_SIZE);
        editor.setPreferredSize(EDIT_FIELD_DEFAULT_SIZE);

        // Add UI components on the panel
        panel.add(label);
        panel.add(editor);

        return panel;
    }

    public PluginSettings showAndGetSettings()
    {
        this.show();

        return new PluginSettings();
    }
}