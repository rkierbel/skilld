<script lang="ts">
	let inputValue: string = '';

	async function handleSubmit(event: Event): Promise<void> {
		event.preventDefault();
		const url = `http://localhost:5666/insee/sirene/natural-person?term=${encodeURIComponent(inputValue)}`;
		console.log('url:', url);
		try {
			const response = await fetch(url);
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			const data = await response.json();
			console.log('Form submitted with:', data);
		} catch (error) {
			console.error('There was a problem with the fetch operation:', error);
		}
	}
</script>

<h1>Dig</h1>
<h2>Every Fraudster's Worst Nightmare</h2>
<form on:submit={handleSubmit}>
	<div>
		<input type="text" id="input" bind:value={inputValue} placeholder="Enter a search value" />
	</div>
	<button type="submit">Dig Deep</button>
</form>

<style>
	h1 {
		text-align: center;
	}

	h2 {
		text-align: center;
		color: #666;
	}

	form {
		max-width: 400px;
		margin: 0 auto;
		padding: 1rem;
		border: 1px solid #ccc;
		border-radius: 8px;
		background-color: #f9f9f9;
	}

	div {
		margin-bottom: 1rem;
	}

	label {
		display: block;
		margin-bottom: 0.5rem;
		font-weight: bold;
	}

	input[type='text'] {
		width: 100%;
		padding: 0.5rem;
		border: 1px solid #ccc;
		border-radius: 4px;
		box-sizing: border-box;
	}

	button {
		display: block;
		width: 100%;
		padding: 0.75rem;
		border: none;
		border-radius: 4px;
		background-color: #007bff;
		color: white;
		font-size: 1rem;
		cursor: pointer;
	}

	button:hover {
		background-color: #0056b3;
	}
</style>
