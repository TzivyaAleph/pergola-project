import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class
import Beam.Beam;

class main {
    public static void main(String[] args) {
        Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Would you like the Pro version? (Y/N)");
        String ans = myObj1.nextLine();  // Read user input
        if(Objects.equals(ans, "Y"))
            { Pro();}
        else
            { Regular();}
    }
    public static void regular()
    {
        userInputRegular()

    }
    /**
     * The function takes care of the regular version.
     * It gets from the user the length, width and hight of the space, the thickness of a beam, the incline and exit meter.
     * It prints to the user: amount of space between beams, amount of beams
     */
    public static void userInputRegular()
    {
        System.out.println("Regular");  // Output user input
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter length: (in cm)");
        float length = myObj.nextFloat();  // Read user input
        System.out.println("Please enter width: (in cm)");
        float width = myObj.nextFloat();  // Read user input
        System.out.println("Please enter beam thickness: (in cm)");
        float beam_thickness = myObj.nextFloat();  // Read user input
        System.out.println("Please enter incline: (in cm)");
        float incline = myObj.nextFloat();  // Read user input
        System.out.println("Please enter output of beam: (in cm)");
        float output = myObj.nextFloat();  // Read user input
        System.out.println("Please enter the hight: (in cm)");
        float hight = myObj.nextFloat();  // Read user input

    }
    /**
     * prints the data of the regular version
     */
    public static void printRegularData(float lenght, float width, float beam_thickness, float incline, float output,float hight)
    {
        float space = num_of_space_between_beam(width, beam_thickness);
        System.out.println("amount of space between beams: " + space);
        float num_of_beams = num_of_beam(width, beam_thickness);
        System.out.println("amount of beam: " + num_of_beams);
        float length_of_woods = length_of_wood(length, incline, output);
        System.out.println("the lenght of a wood: " + length_of_woods);
        float hight_of_amuds = hight_of_poll(hight, incline, beam_thickness, length);
        System.out.println("the hight of a amud: " + hight_of_amuds);
        float num_of_space_between_amuds = num_of_space_between_poll(width, beam_thickness);
        System.out.println("amount of space between amuds: " + num_of_space_between_amuds);
        float num_of_amuds= num_of_amud(width, beam_thickness);
        System.out.println("amount of amuds: " + num_of_amuds);
    }
    /**
     * 
     */
    public static void Pro()
    {
        System.out.println("Pro");  // Output user input
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        Regular();
        String ans1;
        public List<Beam> beams = new ArrayList<>();
        do {
            Beam beam1 = new Beam();
            System.out.println("Please enter beam details: (in cm)");
            System.out.println("Please enter hight: (in cm)");
            beam1.hight = myObj.nextFloat();
            System.out.println("Please enter thickness: (in cm)");
            beam1.bean_thickness = myObj.nextFloat();
            System.out.println("Please enter length: (in cm)");
            beam1.lengths.add(myObj.nextFloat());
            System.out.println("Would you like to enter another length of beam? (Y/N)");
            String ans = myObj.nextLine();
            while(Objects.equals(ans, "Y"))
            {
                System.out.println("Please enter length: (in cm)");
                beam1.lengths.add(myObj.nextFloat());
                System.out.println("Would you like to enter another length of beam? (Y/N)");
                ans = myObj.nextLine();
            }
            System.out.println("Would you like to enter another kind of beam? (Y/N)");
            ans1 = myObj.nextLine();
            beams.add(beam1);
        } while(Objects.equals(ans1, "Y"));
        public List<Beam> needed_beams = new ArrayList<>();
        needed_beams = shadowingCalculation(beams);
    }

    public static List<beam> shadowingCalculation(List<beam> beams)
    {
        
    }

    /**
     * 
     */
    public static float num_of_beam(float width, float thickness)
    {
        int x = (int)width / 75;
        float y = (x + 1) * thickness;
        float z = width - y;
        float result = z / x;
        while (result >= 75)
        {
            x = x + 1;
            y = (x + 1) * thickness;
            z = width - y;
            result = z / x;
        }
        return x+1;
    }

    public static float num_of_space_between_beam(float width, float thickness)
    {
        int x = (int)width / 75;
        float y = (x + 1) * thickness;
        float z = width - y;
        float result = z / x;
        while (result >= 75)
        {
            x = x + 1;
            y = (x + 1) * thickness;
            z = width - y;
            result = z / x;
        }
        return result;
    }
    /**
     * 
     */
    public static float length_of_wood(float length, float incline, float output)
    {
        return length+output+(incline/100*length);//????
    }
    /**
     * 
     */
    public static float hight_of_poll(float hight, float incline, float beam_thicknss, float length)
    {
        return hight-bean_thickness-(incline/100*length);
    }
    /**
     * 
     */
    public static float num_of_space_between_poll(float width, float beam_thicknss)
    {
        if (beam_thickness <= 7)
        {
            int x = (int) width / 300;
            float y = (x + 1) * beam_thickness;
            float z = width - y;
            float result = z / x;
            while (result > 300) {
                x = x + 1;
                y = (x + 1) * beam_thicknesss;
                z = width - y;
                result = z / x;
            }
            return result;
        }
        else
        {
            int x = (int) width / 400;
            float y = (x + 1) * beam_thickness;
            float z = width - y;
            float result = z / x;
            while (result > 400) {
                x = x + 1;
                y = (x + 1) * beam_thicknesss;
                z = width - y;
                result = z / x;
            }
            return result;
        }
    }
    /**
     * 
     */
    public static float num_of_amud(float width, float beam_thicknss)
    {
        if (beam_thickness <= 7)
        {
            int x = (int) width / 300;
            float y = (x + 1) * beam_thicknesss;
            float z = width - y;
            float result = z / x;
            while (result > 300) {
                x = x + 1;
                y = (x + 1) * beam_thicknessss;
                z = width - y;
                result = z / x;
            }
            return x+1;
        }
        else
        {
            int x = (int) width / 400;
            float y = (x + 1) * beam_thicknesss;
            float z = width - y;
            float result = z / x;
            while (result > 400) {
                x = x + 1;
                y = (x + 1) * beam_thicknessss;
                z = width - y;
                result = z / x;
            }
            return x+1;
        }
    }

}

