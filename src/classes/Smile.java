package classes;

public class Smile {
    public static void main(String args[]) {
        VKApi api = new VKApi();
        try {
            //System.out.println(api.isLogged());
            
            

            //System.out.println(api.isLogged());
            //try {
            //JSONObject jo = api.executeApiMethod("messages.get?", "time_offset=4000");
            //System.out.println(jo.toString());
            //ArrayList<Message> message = Message.parse(jo.toString());
            } catch (Exception e) {System.out.println("just exception");}
        //} catch (IOException ioe) {System.out.println("ioexception");}
        //catch (classes.VKException vke) {System.out.println("vkexception");}
    }
}
