package com.darkset.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MockitoAnnotationTest {

//    @BeforeEach
//    public void init(){
//        MockitoAnnotations.openMocks(this);
//    }

    @Mock
    List<String> mockitoList;

    MyList listMock = mock(MyList.class);

    MyList spy = spy(new MyList());

    @Test
    public void whenMockAnnotation(){
       String name =  mockitoList.get(10);

        Mockito.verify(mockitoList).get(10);

        Mockito.when(mockitoList.size()).thenReturn(10);
        assertEquals(10 , mockitoList.size());

    }

    @Test
    @DisplayName("mockito 1 test")
    public void testingMockitoAnnotations(){
        when(listMock.add(anyString())).thenReturn(false);

        boolean added = listMock.add("thank you");
        assertThat(added).isFalse();
    }

    @Test
    @DisplayName("mockito 2 test")
    public void testingMockitoAnnotationsSecondVariant(){
        doReturn(false).when(listMock).add(anyString());

        boolean added = listMock.add("thank you");
        assertThat(added).isFalse();
    }

    @Test
    @DisplayName("mockito 3 test")
    public void testingMockitoAnnotationsThrowExceptions(){
        when(listMock.add(anyString())).thenThrow(IllegalStateException.class );

        assertThrows(IllegalStateException.class , ()-> listMock.add("vasya"));
    }

    @Test
    @DisplayName("mockito 4 test")
    public void testingMockitoAnnotationsThrowExceptionsVoidTypeMethod(){
        doThrow(NullPointerException.class).when(listMock).clear();

        assertThrows(NullPointerException.class , ()-> listMock.clear());
    }

    @Test
    @DisplayName("mockito 5 test")
    public void testingMockitoAnnotationsMultipleCalls(){
        when(listMock.add(anyString())).thenReturn(false).thenThrow(IllegalStateException.class);

        assertThrows(IllegalStateException.class , ()-> {
            listMock.add("vasya");
            listMock.add("name");
        });
    }

    @Test
    @DisplayName("mockito 6 test")
    public void testingMockitoAnnotationsSpy(){
        doThrow(NullPointerException.class).when(spy).size();


        assertThrows(NullPointerException.class, () -> spy.size());
    }

    @Test
    @DisplayName("mockito 7 test")
    public void testingMockitoAnnotationsCallingRealUnderlyingMethod(){
        when(listMock.size()).thenCallRealMethod();


        assertThat(listMock).hasSize(1);
    }

    @Test
    @DisplayName("mockito 8 test")
    public void testingMockitoAnnotationsWithCustomAnswer(){
        doAnswer(invocation -> "Always the same").when(listMock).get(anyInt());

        String element = listMock.get(1);
        assertThat(element).isEqualTo("Always the same");
    }








}
