/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23vvv1;

/**
 *
 * @author aleksandr
 */
public class RecIntegral {
    
    private static final double MIN_VALUE = 0.0000001;
    private static final double MAX_VALUE = 10000000;
    
    private double upperLim;
    private double lowLim;
    private double step;
    private double result;
    
    private void validateRange(double value, String fileName) throws InvalidRangeException {
        if (value < MIN_VALUE || value > MAX_VALUE){
            throw new InvalidRangeException(
                    "Значение: "+ fileName + " должно быть в диапазоне от " +
                     MIN_VALUE + " до " + MAX_VALUE + "\n", value
            );
        }
    }
    
    private void validateParameters() throws InvalidRangeException {
        // Проверка диапазонов
        validateRange(lowLim, "Нижний предел");
        validateRange(upperLim, "Верхний предел");
        validateRange(step, "Шаг интегрирования");
        
        // Проверка: нижний предел должен быть меньше верхнего
        if (lowLim >= upperLim) {
            throw new InvalidRangeException("Ошибка: нижний предел должен быть меньше верхнего предела");
        }
        
        // Проверка: шаг должен быть положительным
        if (step <= 0) {
            throw new InvalidRangeException("Ошибка: шаг интегрирования должен быть положительным");
        }
        
        // Проверка: шаг не должен превышать интервал интегрирования
        if (step > (upperLim - lowLim)) {
            throw new InvalidRangeException("Ошибка: шаг интегрирования не может быть больше интервала интегрирования");
        }
    }
    
    public RecIntegral(double lowLim, double upperLim, double step) throws InvalidRangeException{
        
        this.lowLim = lowLim;
        this.upperLim = upperLim;
        this.step = step;
        this.result = 0.0;
        
        validateParameters();
        if (step > (upperLim - lowLim)){
            double value = step;

        }
    }
    
    public RecIntegral(double lowLim, double upperLim, double step, double result) throws InvalidRangeException{
        this.lowLim = lowLim;
        this.upperLim = upperLim;
        this.step = step;
        this.result = result;
        
        validateParameters();
    }
    
    
    
    public double GetUpperLim() {return upperLim;}
    
    public double GetLowLim() {return lowLim;}
    
    public double GetStep() {return step;}
    
    public double GetResult() {return result;}
    
    public void  setResult(double result){this.result = result;}  
    
    
    public double calculate(double LowLim, double upperLim, double step){
        int n = (int)((upperLim - LowLim) / step);
        double one = 0;
        double integral = 0;
            
        for (int i = 1; i < n; i++) {
            double x = LowLim + i * step;
            if (Math.abs(x) > 1e-10) {
                integral += Math.exp(x) / x;
                one = Math.exp(x) / x;
            }
        }
            
        double fa = (Math.abs(LowLim) > 1e-10) ? Math.exp(LowLim) / LowLim : 0;
        double fb = (Math.abs(upperLim) > 1e-10) ? Math.exp(upperLim) / upperLim : 0;
        
        double lastFullX = LowLim + n * step;
        double fLast = (Math.abs(lastFullX) > 1e-10) ? Math.exp(lastFullX) / lastFullX : 0;

        double lastStep = upperLim - lastFullX;

        if (Math.abs(lastStep) < 1e-10) {
            integral = (step / 2) * (fa + 2 * integral + fLast);
        } else {
            integral = (step / 2) * (fa + 2 * integral + fLast) + (lastStep / 2) * (fLast + fb);
        }
        
        return integral;  
    }
    
}

 
