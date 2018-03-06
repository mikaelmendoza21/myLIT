package myLiTAPI.PiControls;

import com.pi4j.io.gpio.*;

public class GPIOController
{
    public static boolean isPinConfigured = false;
    private static int totalPins = 2;
    private static GpioPinDigitalOutput[] pins = new GpioPinDigitalOutput[totalPins];

    public void setUp()
    {
        if(!isPinConfigured || pins[0] == null)
        {
            //Instantiate a new GpioController
            GpioController gpio = GpioFactory.getInstance();

            for(int index = 0; index < totalPins; index++)
            {
                //Provision Pin
                pins[index] = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(index), "MyLED", PinState.LOW);

                //Set Shutdown state
                pins[index].setShutdownOptions(true, PinState.LOW);

                System.out.println("\nPin Provisioned => " + pins[index].toString());
            }

            isPinConfigured = true;
        }
    }

    public void performAction(Device device)
    {
        switch (device.getAction())
        {
            //If action is zero then turn pin off.
            case (0):
            {
                System.out.println("Turning Device at Pin " + device.getPinNumber() + " OFF");
                pins[device.getPinNumber()].low();
                break;
            }
            //If action is one then turn pin on.
            case (1):
            {
                System.out.println("Turning Device at Pin " + device.getPinNumber() + " ON");
                pins[device.getPinNumber()].high();
                break;
            }
        }
    }

    public int updateDeviceStatus(Device device)
    {
        //If the pin is valid.
        if (0 <= device.getPinNumber() && device.getPinNumber() <= 15) {
            //No pin exist return 2 for error.
            if (pins[device.getPinNumber()] == null) {
                return 2;
            }
            //Check if off returns 0 if off.
            else if (pins[device.getPinNumber()].isLow()) {
                return 0;
            }
            //Light is on return 1.
            else {
                return 1;
            }
        }
        //Pin not valid return 2 for error.
        else
        {
            //The integer received for pin is not between 0 and 15.
            return 2;
        }
    }
}
