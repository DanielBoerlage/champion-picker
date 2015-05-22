package championpicker.uncertainty;

import org.json.JSONObject;

import championpicker.champ.ChampStat;

public class UncertainParam extends UncertainValue implements ChampStat {

    private String name;

    public UncertainParam(String name, double value, int experiance) {
        super(value, experiance);
        this.name = name;
    }

    // public static UncertainParam parseUncertainParam(String str) {
    //     String name = str.substring(str.indexOf(".") + 1, str.indexOf(":"));
    //     String uvStr = str.substring(str.indexOf(":") + 2);
    //     UncertainValue uv = UncertainValue.parseUncertainValue(uvStr);
    //     return new UncertainParam(name, uv.getValue(), uv.getConfidence());
    // }

    public String getName() {
        return name;
    }

    public JSONObject toJSON() {
        return null;
    }
}
