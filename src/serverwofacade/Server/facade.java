/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverwofacade.Server;

/**
 *
 * @author PAktobchawa
 */
public class facade {
    public void StartServer() {
        ScheduleServer server = new ScheduleServer();
        server.startBooting();
        StartProcess(server);
    }
    
    public void StopServer() {
        ScheduleServer server = new ScheduleServer();
        StopProcess(server);
        server.shutdown();
    }
        
    
    private void StartProcess(ScheduleServer server) {
        server.readSystemConfigFile();
        server.init();
        server.initializeContext();
        server.initializeListeners();
        server.createSystemObjects();
    }
    
    private void StopProcess(ScheduleServer server) {
        server.releaseProcesses();
	server.destory();
	server.destroySystemObjects();
	server.destoryListeners();
	server.destoryContext();
    }
}
