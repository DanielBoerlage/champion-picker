package championpicker.uncertainty;

import championpicker.champ.ChampionParam;

public class UncertainParam extends UncertainValue implements ChampionParam {

    private String name;

    public UncertainParam(String name, double value, int confidence) {
        super(value, confidence);
        this.name = name;
    }

    public static UncertainParam parseUncertainParam(String str) {
        String name = str.substring(str.indexOf(".") + 1, str.indexOf(":"));
        String uvStr = str.substring(str.indexOf(":") + 2);
        UncertainValue uv = UncertainValue.parseUncertainValue(uvStr);
        return new UncertainParam(name, uv.getValue(), uv.getConfidence());
    }

    public Object key() {
        return name;
    }

    public Object value() {
        return super.toString();
    }

}
