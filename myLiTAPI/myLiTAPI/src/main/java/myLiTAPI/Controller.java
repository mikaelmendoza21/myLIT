package myLiTAPI;

import myLiTAPI.PiControls.Device;
import myLiTAPI.PiControls.GPIOController;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@SuppressWarnings("Duplicates")
@RestController
public class Controller
{
    public static GPIOController piController;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<Device> Home(@RequestBody List<Device> devices)throws InterruptedException, IOException, ParseException
    {
        if(piController == null)
        {
            piController = new GPIOController();
            piController.setUp();
        }

        devices.forEach( device -> piController.performAction(device));

        devices.forEach(device -> device.setStatus(piController.updateDeviceStatus(device)));

        //piController.performAction(device);

        //device.setStatus(piController.updateDeviceStatus(device));

        return devices;
    }
}
