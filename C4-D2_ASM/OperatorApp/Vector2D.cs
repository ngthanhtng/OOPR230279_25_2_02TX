using System;

namespace OperatorApp
{
    public class Vector2D
    {
        public double X { get; private set; }
        public double Y { get; private set; }

        public Vector2D() : this(0, 0) {}

        public Vector2D(double x, double y)
        {
            X = x;
            Y = y;
        }

        public double DoDai => Math.Sqrt(X * X + Y * Y);

        // +
        public static Vector2D operator +(Vector2D a, Vector2D b)
        {
            return new Vector2D(a.X + b.X, a.Y + b.Y);
        }

        // -
        public static Vector2D operator -(Vector2D a, Vector2D b)
        {
            return new Vector2D(a.X - b.X, a.Y - b.Y);
        }

        // Vector * double
        public static Vector2D operator *(Vector2D v, double k)
        {
            return new Vector2D(v.X * k, v.Y * k);
        }

        // double * Vector
        public static Vector2D operator *(double k, Vector2D v)
        {
            return v * k;
        }

        // unary -
        public static Vector2D operator -(Vector2D v)
        {
            return new Vector2D(-v.X, -v.Y);
        }

        // nâng cao: dot product
        public static double operator *(Vector2D a, Vector2D b)
        {
            return a.X * b.X + a.Y * b.Y;
        }

        // nâng cao: ==
        public static bool operator ==(Vector2D a, Vector2D b)
        {
            if (ReferenceEquals(a, b)) return true;

            if (a is null || b is null) return false;

            return a.X == b.X && a.Y == b.Y;
        }

        // nâng cao: !=
        public static bool operator !=(Vector2D a, Vector2D b)
        {
            return !(a == b);
        }

        // implicit tuple -> Vector2D
        public static implicit operator Vector2D((double x, double y) data)
        {
            return new Vector2D(data.x, data.y);
        }

        public override bool Equals(object obj)
        {
            if (obj is Vector2D other) return this == other;

            return false;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(X, Y);
        }

        public override string ToString()
        {
            return $"({X:F2}, {Y:F2})";
        }
    }
}