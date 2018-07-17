
import edu.kit.cm.WorkspaceManagement.Workspace.Service.WorkspaceAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkspaceAdapterTest {
    JSONObject jsonObject;
    private static WorkspaceAdapter wa;

    @BeforeClass
    public static void initClass() {
        wa = WorkspaceAdapter.getInstance();
    }

    @Before
    public void intTest() {
        jsonObject = new JSONObject();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLayoutTestException0() {
        wa.addLayout(jsonObject);
        assertEquals(jsonObject, wa.getLayout());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLayoutTestException1() {
        wa.addLayout(jsonObject);
        assertEquals(jsonObject, wa.getLayout());
    }

    @Test
    public void getLayoutTest0() {
        try {
            jsonObject = new JSONObject("{\"rooms\":[{\"pos\"\t\t\t:[{\"x\":1,\"y\":1},{\"x\":1,\"y\":1},{\"x\":1,\"y\":1},{\"x\":1,\"y\":1}],\n" +
                    "  \"id\" \t\t\t:1,\n" +
                    "  \"portalGates\"\t:[{\"type\":door,\"pos\": [{\"x\":1,\"y\":1},{\"x\":1,\"y\":1}]},\n" +
                    "    {\"type\":\"passage\",\"pos\": [{\"x\":1,\"y\":1},{\"x\":1,\"y\":1}]}]}]}");
        } catch (JSONException e) {
        }
        wa.addLayout(jsonObject);
        try {
            jsonObject.put("poolElements", new JSONArray());
        } catch (JSONException e) {
        }
        assertEquals(jsonObject.toString(), wa.getLayout().toString());
    }

    @Test
    public void getLayoutTest1() {
        try {
            jsonObject = new JSONObject("{\"rooms\":[{\"pos\"\t\t\t:[{\"x\":1,\"y\":1},{\"x\":1,\"y\":1},{\"x\":1,\"y\":1},{\"x\":1,\"y\":1}],\n" +
                    "  \"id\" \t\t\t:1,\n" +
                    "  \"portalGates\"\t:[{\"type\":door,\"pos\": [{\"x\":1,\"y\":1},{\"x\":1,\"y\":1}]},\n" +
                    "    {\"type\":\"passage\",\"pos\": [{\"x\":1,\"y\":1},{\"x\":1,\"y\":1}]}]}]}");
        } catch (JSONException e) {
        }
        try {
            JSONArray jsonArray = new JSONArray("[\n" +
                    "{\"pos\":{\"x\":10,\"y\":1},\"id\":1,\"type\":\"PC\",\"width\":10,\"length\":10}, \n" +
                    "  {\"pos\":{\"x\":10,\"y\":1},\"id\":2,\"type\":\"PC\",\"width\":10,\"length\":10}]");
            jsonObject.put("poolElements", jsonArray);
        } catch (JSONException e) {
            e.fillInStackTrace();
        }
        wa.addLayout(jsonObject);
        assertEquals(jsonObject.toString(), wa.getLayout(1).toString());
    }

}
