package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 14.0;
    private static final double NORMAL_PRESSURE_VALUE = 20.0;
    private static final double HIGH_PRESSURE_VALUE = 25.0;

    private Alarm alarm;
    private Sensor sensor;


    @Before
    public void setup() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecauseLowPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecauseHighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOffWithNormalPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}