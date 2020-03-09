package Interface;

import com.intellij.openapi.ui.DialogWrapper;

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
        JPanel dialogPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Run image under VM?");

        label.setPreferredSize(new Dimension(200, 50));
        dialogPanel.add(label, BorderLayout.CENTER);

        return dialogPanel;
    }

    public PluginSettings showAndGetSettings()
    {
        this.showAndGet();

        return new PluginSettings();
    }
}