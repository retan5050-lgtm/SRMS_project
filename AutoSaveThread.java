class AutoSaveThread extends Thread { 
    private StudentManager manager;
    private String filename;

    public AutoSaveThread(StudentManager manager, String filename) {
        this.manager = manager;
        this.filename = filename;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Auto-save every 5 minutes
                Thread.sleep(300000);
                FileHandler.saveToFile(manager.getStudents(), filename);
                System.out.println("Data auto-saved.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
