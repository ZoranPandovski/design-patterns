using System;

namespace FactoryPatternSample
{
    interface Product
    {
        string PrintProduct();
    }

    class MobilePhone : Product
    {
        public string PrintProduct()
        {
            string Final = "From MobilePhone ";
            return Final;
        }
    }

    class Laptop : Product
    {
        public string PrintProduct()
        {
            string Final = "From Laptop ";
            return Final;
        }
    }
    class clsFactory
    {
        static public Product CreateandReturnObj(int cChoice)
        {
            Product ObjSelector = null;

            switch (cChoice)
            {
                case 1:
                    ObjSelector = new MobilePhone();
                    break;
                case 2:
                    ObjSelector = new Laptop();
                    break;
                default:
                    ObjSelector = new MobilePhone();
                    break;
            }
            return ObjSelector;

        }
    }
    class FactoryPattern
    {
        static void Main()
        {
            Product ObjIntrface = null;

            int option = Int32.Parse(Console.ReadLine());
            ObjIntrface = clsFactory.CreateandReturnObj(option);
            Console.WriteLine(ObjIntrface.PrintProduct());            

            // Wait for user
            Console.ReadKey();
        }
    }
}
