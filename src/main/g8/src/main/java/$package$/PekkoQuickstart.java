package $package$;

import org.apache.pekko.actor.typed.ActorSystem;

import java.io.IOException;
public class PekkoQuickstart {
  public static void main(String[] args) {
    //#actor-system
    final ActorSystem<GreeterMain.SayHello> greeterMain = ActorSystem.create(GreeterMain.create(), "hellopekko");
    //#actor-system

    //#main-send-messages
    greeterMain.tell(new GreeterMain.SayHello("Charles"));
    //#main-send-messages

    try {
      System.out.println(">>> Press ENTER to exit <<<");
      System.in.read();
    } catch (IOException ignored) {
    } finally {
      greeterMain.terminate();
    }
  }
}
