package Actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ShowConfigDialog extends AnAction
{
    @Override public void actionPerformed(@NotNull AnActionEvent anActionEvent)
    {
        System.out.println("Hello");
    }
}
