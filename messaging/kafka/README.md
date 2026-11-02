# Kafka / Spring Cloud Stream practice

- [`producer`](producer/): producer/function-side learning application.
- [`consumer`](consumer/): message-consumer examples, including `RiderLocation` data.

Open each project's POM independently. Both POMs target Java 21. A compatible Kafka broker and matching binding/topic/group configuration are required; inspect each `application.yaml` before starting.

Some older controller/listener approaches are commented out while function-based alternatives remain in the sources. A commented `/send` controller is **not an available HTTP endpoint**. This repository does not promise all alternative approaches run together.

No broker, integration environment or end-to-end message-delivery test was started during cleanup. Keep secrets out of any broker configuration you add later.
