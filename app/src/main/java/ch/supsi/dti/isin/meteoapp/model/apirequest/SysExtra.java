package ch.supsi.dti.isin.meteoapp.model.apirequest;

public class SysExtra {

    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return "SysExtra{" +
                "pod='" + pod + '\'' +
                '}';
    }
}

