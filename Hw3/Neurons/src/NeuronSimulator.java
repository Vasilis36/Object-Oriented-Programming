package vilia002.hw3.neurons;

import java.util.ArrayList;

public class NeuronSimulator {

	public static void main(String[] args) {
		// TEST PART 1
		System.out.println("Test part 1:");
		System.out.println("--------------------");

		Position position1 = new Position(0, 1);
		Position position2 = new Position(1, 0);
		Position position3 = new Position(1, 1);

		Neuron neuron1 = new Neuron(position1, 0.5);
		Neuron neuron2 = new Neuron(position2, 1.0);
		Neuron neuron3 = new Neuron(position3, 2.0);

		neuron1.connection(neuron2);
		neuron2.connection(neuron3);
		neuron1.receivesStimulus(10);

		System.out.println("Signals : ");
		System.out.println(neuron1.getSignal());
		System.out.println(neuron2.getSignal());
		System.out.println(neuron3.getSignal());

		System.out.println();
		System.out.println("First connection of neuron 1");
		System.out.println(neuron1.getConnection(0));

		// END TEST PART 1

		// TEST PART 2
		System.out.println("Test part 2:");
		System.out.println("--------------------");

		Position position5 = new Position(0, 0);
		CumulativeNeuron neuron5 = new CumulativeNeuron(position5, 0.5);
		neuron5.receivesStimulus(10);
		neuron5.receivesStimulus(10);
		System.out.println("Signal of cumulative neuron -> " + neuron5.getSignal());

		// END TEST PART 2

		// TEST PART 3
		System.out.println();
		System.out.println("Test part 3:");
		System.out.println("--------------------");
		Brain brain = new Brain();

		brain.addNeuron(new Position(0, 0), 0.5);
		brain.addNeuron(new Position(0, 1), 0.2);
		brain.addNeuron(new Position(1, 0), 1.0);

		brain.addCumulativeNeuron(new Position(1, 1), 0.8);
		brain.createConections();
		brain.stimulate(0, 10);

		System.out.println("Signal of 3rd neuron -> " + brain.probe(3));
		System.out.println(brain);
		// END TEST PART 3
	}
}
