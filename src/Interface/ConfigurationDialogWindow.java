package Interface;

import Services.VirtualMachineConfiguration;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.Splitter;
import com.intellij.ui.EditorTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class ConfigurationDialogWindow extends DialogWrapper
{
    private static int DEFAULT_HEIGHT      = 40;
    private static int DEFAULT_BUTTON_SIDE = DEFAULT_HEIGHT;
    private static int DEFAULT_WIDTH       = 1000;

    private static final Dimension PANELS_DEFAULT_SIZE     = new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    private static final Dimension LABELS_DEFAULT_SIZE     = new Dimension(200, DEFAULT_HEIGHT);
    private static final Dimension EDIT_FIELD_DEFAULT_SIZE = new Dimension(650, DEFAULT_HEIGHT);
    private static final Dimension COMBO_BOX_DEFAULT_SIZE  = new Dimension(150, DEFAULT_HEIGHT);

    private static final Dimension BUTTON_DEFAULT_SIZE     = new Dimension(DEFAULT_BUTTON_SIDE,
                                                                           DEFAULT_BUTTON_SIDE);

    private EditorTextField  path;
    private EditorTextField  arguments;
    private ComboBox<String> machines;

    public ConfigurationDialogWindow()
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
        VirtualMachineConfiguration configuration = VirtualMachineConfiguration.getInstance();
        JPanel pluginSettingsPanel = new JPanel(new VerticalLayout());
        pluginSettingsPanel.setPreferredSize(PANELS_DEFAULT_SIZE);

        ArrayList<String> machineList = new ArrayList<>();
        machineList.add("i386");
        machineList.add("arm");
        machineList.add("amd");

        machines = new ComboBox<String>();

        for(String machine: machineList) {
            machines.addItem(machine);

            if (machine.equals(configuration.getMachine())) {
                machines.setSelectedIndex(machines.getItemCount() - 1);
            }
        }

        pluginSettingsPanel.add(getMachineSettingPanel(machines));

        path = new EditorTextField(configuration.getBinaryPath());
        pluginSettingsPanel.add(getBinaryImagePanel(path));

        arguments = new EditorTextField(configuration.getCommandLineOptions());
        pluginSettingsPanel.add(getCommandLineArgumentsPanel(arguments));

        pluginSettingsPanel.add(new Splitter());

        return pluginSettingsPanel;
    }

    @Override protected void doOKAction()
    {
        VirtualMachineConfiguration configuration = VirtualMachineConfiguration.getInstance();

        configuration.setMachine(machines.getSelectedItem().toString());
        configuration.setBinaryPath(path.getText());
        configuration.setCommandLineOptions(arguments.getText());

        super.doOKAction();
    }

    @NotNull private JPanel getMachineSettingPanel(ComboBox<String> comboBox)
    {
        JPanel panel = new JPanel(new HorizontalLayout());
        JLabel label = new JLabel("Virtual machine type:");

        // Set Label Properties
        panel.setPreferredSize(PANELS_DEFAULT_SIZE);
        label.setPreferredSize(LABELS_DEFAULT_SIZE);
        comboBox.setPreferredSize(COMBO_BOX_DEFAULT_SIZE);

        // Add UI onto panel
        panel.add(label);
        panel.add(comboBox);

        return panel;
    }

    @NotNull private JPanel getBinaryImagePanel(EditorTextField editor)
    {
        JPanel  panel   = new JPanel(new HorizontalLayout());
        JButton button  = new JButton("...");
        JLabel  label   = new JLabel("Binary Image Path:");

        // Set sizes
        panel.setPreferredSize(PANELS_DEFAULT_SIZE);
        label.setPreferredSize(LABELS_DEFAULT_SIZE);
        button.setPreferredSize(BUTTON_DEFAULT_SIZE);
        editor.setPreferredSize(EDIT_FIELD_DEFAULT_SIZE);

        button.addActionListener(e -> {
            editor.setText("Button clicked: " + new Date().getTime());
        });

        // Add UI components on the panel
        panel.add(label);
        panel.add(editor);
        panel.add(button);

        return panel;
    }

    @NotNull private JPanel getCommandLineArgumentsPanel(EditorTextField editor)
    {
        JPanel panel = new JPanel(new HorizontalLayout());
        JLabel label = new JLabel("Command Line Arguments:");

        // Set sizes
        panel.setPreferredSize(PANELS_DEFAULT_SIZE);
        label.setPreferredSize(LABELS_DEFAULT_SIZE);
        editor.setPreferredSize(EDIT_FIELD_DEFAULT_SIZE);

        // Add UI components on the panel
        panel.add(label);
        panel.add(editor);

        return panel;
    }
}