package myLiTAPI.PiControls;

import java.util.EnumSet;

public enum DeviceStatus
{
    TURNOFF(0, "TurnOn"),
    TURNON(1, "TurnOff");

    private final int value;
    private final String name;

    DeviceStatus(int value, String name)
    {
        this.value = value;
        this.name = name;
    }

    public int getValue()
    {
        return this.value;
    }
    public String getName()
    {
        return this.name;
    }
}
