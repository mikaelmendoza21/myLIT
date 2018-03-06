package myLiTAPI.PiControls;


public class Device
{
    public int pinNumber;
    private int action;
    private int status;

    public int getPinNumber()
    {
        return this.pinNumber;
    }

    public void setPin(int pin)
    {
        this.pinNumber = pin;
    }

    public int getAction()
    {
        return action;
    }
    public void setAction(int action)
    {
        this.action = action;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}
