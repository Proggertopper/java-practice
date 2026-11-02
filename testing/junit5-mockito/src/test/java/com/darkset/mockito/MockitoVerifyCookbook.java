package com.darkset.mockito;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoVerifyCookbook {

    List<String> mockedList = mock(MyList.class);

    @Test
    @DisplayName("mockito 1 test of verify practise")
    void testingMockitoAnnotationsVerify(){
        mockedList.size();
        verify(mockedList).size();
    }

    @Test
    @DisplayName("mockito 2 test of verify practise")
    void testingMockitoAnnotationsVerify1OrMoreInteractions(){
        mockedList.size();
        verify(mockedList , times(1)).size();
    }

    @Test
    @DisplayName("mockito 3 test of verify practise")
    void testingMockitoAnnotationsVerifyNoInteractions(){
//        mockedList.size();
        verifyNoInteractions(mockedList);
        verify(mockedList , times(0)).size();
    }

    @Test
    @DisplayName("mockito 4 test of verify practise")
    void testingMockitoAnnotationsVerifyAndThrowException(){
        mockedList.size();
        mockedList.clear();

        verify(mockedList).size();
        assertThrows(NoInteractionsWanted.class, () -> verifyNoMoreInteractions(mockedList));
    }

    @Test
    @DisplayName("mockito 5 test of verify practise")
    void testingMockitoAnnotationsVerifyInOrderTimes(){
        mockedList.size();
        mockedList.add("add parametr");
        mockedList.clear();

        InOrder order = Mockito.inOrder(mockedList);
        order.verify(mockedList).size();
        order.verify(mockedList).add("add parametr");
        order.verify(mockedList).clear();
    }

    @Test
    @DisplayName("mockito 6 test of verify practise")
    void testingMockitoAnnotationsVerifyInteractionNotOccured(){
        mockedList.size();

        verify(mockedList , never()).clear();
    }

    @Test
    @DisplayName("mockito 7 test of verify practise")
    void testingMockitoAnnotationsVerifyInteractionOccuredAtLeastNTimesAndExactArgumentAndAnyString(){
//        mockedList.clear();
//        mockedList.clear();
//        mockedList.clear();
//
//        verify(mockedList , atLeast(1)).clear();
//        verify(mockedList , atMost(10)).clear();
        mockedList.add("test");

//        verify(mockedList).add("test");
        verify(mockedList).add(anyString());
    }

    @Test
    @DisplayName("mockito 8 test of verify practise")
    void testingMockitoAnnotationsVerifyInteractionUsingArgumentCapture(){
        mockedList.addAll(Lists.<String>newArrayList("someElement"));

        ArgumentCaptor<List<String>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(mockedList).addAll(argumentCaptor.capture());

        List<String> capturedElement = argumentCaptor.getValue();
        assertThat(capturedElement).contains("someElement");
    }




}
