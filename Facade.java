package serverwofacade;

public class Facade {

    private static Facade myfacade = null;

    private Facade() {
    }

    public static Facade getMyFacadeObject() {
        if (myfacade == null) {
            myfacade = new Facade();
        }
        return myfacade;
    }

    public void startserver() {
        ScheduleServer st = new ScheduleServer();
        st.startBooting();
        st.readSystemConfigFile();
        st.init();
        st.initializeContext();
        st.initializeListeners();
        st.createSystemObjects();
        System.out.println("Start working......");
    }

    public void stopserver() {
        ScheduleServer sp = new ScheduleServer();
        System.out.println("After work done.........");
        sp.releaseProcesses();
        sp.destory();
        sp.destroySystemObjects();
        sp.destoryListeners();
        sp.destoryContext();
        sp.shutdown();
    }

}