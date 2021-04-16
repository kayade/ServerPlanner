package sPlanner;

/**
 *
 * @author Kayode
 */
import org.json.JSONObject;
import org.json.JSONArray;

public class Servers {

    public String[] retrieve(String jsonData) {

        String output[] = new String[2];

        try {

            JSONObject outP = new JSONObject(jsonData);

            if (outP.length() == 2) {

                output[0] = outP.getString("sType");
                output[1] = outP.getString("vMachines");
            }

        } catch (Exception se) {

            System.out.println(se);
        }

        return output;
    }

    public int calculate(String serverType, String virtualMachines) {

        int result = 0;

        int sCPU = 0, sRAM = 0, sHDD = 0;
        int tCPU = 0, tRAM = 0, tHDD = 0;
        int dv = 0, md = 0;

        JSONObject ob = null;

        try {

            JSONObject sType = new JSONObject(serverType);

            sCPU = sType.getInt("CPU");
            sRAM = sType.getInt("RAM");
            sHDD = sType.getInt("HDD");

            JSONArray vMachines = new JSONArray(virtualMachines);

            for (int i = 0; i < vMachines.length(); i++) {

                ob = vMachines.getJSONObject(i);

                if ((ob.getInt("CPU") <= sCPU) && (ob.getInt("RAM") <= sRAM) && (ob.getInt("HDD") <= sHDD)) {

                    tCPU += ob.getInt("CPU");
                    tRAM += ob.getInt("RAM");
                    tHDD += ob.getInt("HDD");
                }
            }

            dv = tCPU / sCPU;
            md = tCPU % sCPU;

            if (md > 0) {

                result = dv + 1;

            } else {

                result = dv;
            }

            dv = tRAM / sRAM;
            md = tRAM % sRAM;

            if (md > 0) {

                if ((dv + 1) > result) {

                    result = dv + 1;
                }

            } else {

                if (dv > result) {

                    result = dv;
                }
            }

            dv = tHDD / sHDD;
            md = tHDD % sHDD;

            if (md > 0) {

                if ((dv + 1) > result) {

                    result = dv + 1;
                }

            } else {

                if (dv > result) {

                    result = dv;
                }
            }

        } catch (Exception se) {

            System.out.println(se);
        }

        return result;
    }

}
