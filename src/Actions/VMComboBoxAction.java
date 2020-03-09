package Actions;

import Interface.ConfigDialog;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.ex.ComboBoxAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class VMComboBoxAction extends ComboBoxAction
{

    @Override
    public void actionPerformed(AnActionEvent e)
    {
        if(new ConfigDialog().showAndGet())
        {
            System.out.println("HI");
        }
    }

    @NotNull @Override protected DefaultActionGroup createPopupActionGroup(JComponent jComponent)
    {

        DefaultActionGroup defaultActionGroup = new DefaultActionGroup();

        defaultActionGroup.add(new ShowConfigDialog());
        defaultActionGroup.addSeparator();

        return defaultActionGroup;
    }

    @Override public boolean isDumbAware()
    {
        return false;
    }
}
