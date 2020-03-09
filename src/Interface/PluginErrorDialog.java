package Interface;

import com.intellij.openapi.ui.DialogWrapper;

import javax.annotation.Nullable;
import javax.swing.*;
import java.awt.*;

public class PluginErrorDialog extends DialogWrapper
{
    private String m_errorMessage;

    public PluginErrorDialog(String errorMessage) {
        super(true);
        init();
        setTitle("Error Occurred!");
        m_errorMessage = new String(errorMessage);
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel()
    {
        JPanel dialogPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(m_errorMessage);
        label.setPreferredSize(new Dimension(200, 50));
        dialogPanel.add(label, BorderLayout.CENTER);

        return dialogPanel;
    }
}
