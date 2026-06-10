using System;

namespace PhanSoApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            PhanSo ps1 = new PhanSo(1, 2);
            PhanSo ps2 = new PhanSo(1, 3);

            Console.WriteLine("===== TOAN TU SO HOC =====");
            Console.WriteLine($"ps1 = {ps1}");
            Console.WriteLine($"ps2 = {ps2}");

            Console.WriteLine($"ps1 + ps2 = {ps1 + ps2}");
            Console.WriteLine($"ps1 - ps2 = {ps1 - ps2}");
            Console.WriteLine($"ps1 * ps2 = {ps1 * ps2}");
            Console.WriteLine($"ps1 / ps2 = {ps1 / ps2}");

            Console.WriteLine();
            Console.WriteLine("===== CONG VOI SO NGUYEN =====");
            Console.WriteLine($"ps1 + 2 = {ps1 + 2}");
            Console.WriteLine($"2 + ps1 = {2 + ps1}");

            Console.WriteLine();
            Console.WriteLine("===== TOAN TU SO SANH =====");

            PhanSo ps3 = new PhanSo(2, 4);
            PhanSo ps4 = new PhanSo(1, 3);

            Console.WriteLine($"ps1 = {ps1}");
            Console.WriteLine($"ps3 = {ps3}");
            Console.WriteLine($"ps4 = {ps4}");

            Console.WriteLine($"ps1 == ps3 : {ps1 == ps3}");
            Console.WriteLine($"ps1 != ps4 : {ps1 != ps4}");
            Console.WriteLine($"ps4 < ps1 : {ps4 < ps1}");
            Console.WriteLine($"ps1 > ps4 : {ps1 > ps4}");

            Console.WriteLine();
            Console.WriteLine("===== KIEM TRA NGOAI LE =====");

            try
            {
                PhanSo loi = new PhanSo(1, 0);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}