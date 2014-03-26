package datatype;

public class ComplexNumber<TypeReal, TypeImaginary> {
    
    private final TypeReal real;
    private final TypeImaginary imaginary;

    public ComplexNumber(TypeReal real, TypeImaginary imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public TypeReal getReal() {
        return real;
    }

    public TypeImaginary getImaginary() {
        return imaginary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof ComplexNumber)) return false;
        ComplexNumber complexNumber = (ComplexNumber) obj;
        return ((complexNumber.getReal() == real) && (complexNumber.getImaginary() == imaginary));
    }
}
